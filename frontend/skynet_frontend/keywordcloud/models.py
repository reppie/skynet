from django.db import models
from skynet_frontend.twitter.models import Keyword

from datetime import datetime, timedelta
from math import log
"""
This class is used to generate a keywordcloud for the website. It receives the minimum and maximum font size that should be used and 
a querySet with the keywords and their respective counts. Then, it generates the cloud and stores it in `items`.
"""
class KeywordCloud:
    """ A list with the generated KeywordFontSizes """
    items = None
    smallest = None
    largest = None
    step = None
    
    def __init__(self, query_set, min_font_size=14, max_font_size=30, num_keywords=50, exclude=[]):
        exclude_ids = []
        for word in exclude:
            query = Keyword.objects.filter(keyword=word)
            if len(query):
                keyword = query[0]
                exclude_ids.append(keyword.id)
        
        blacklist = BlacklistItem.objects.all().values_list('keyword__id', flat=True)
        exclude_ids.extend(blacklist)

        excludestring = ""
        for exclude_id in exclude_ids:
            excludestring += str(exclude_id) + ","
        excludestring = excludestring[:-1]    

        from django.db import connection
        cursor = connection.cursor()
        whereclause = ""
        for word in exclude:
            whereclause += " AND U4.keyword = '%s'" % word
            
        query = "SELECT twitter_keyword.keyword , COUNT(  twitter_keyword.keyword ) AS count FROM  twitter_keyword LEFT OUTER JOIN  twitter_tweet_keywords ON (  twitter_keyword.id =  twitter_tweet_keywords.keyword_id ) WHERE EXISTS(SELECT DISTINCT U0.id FROM  twitter_tweet U0 INNER JOIN  twitter_place U1 ON ( U0.place_id = U1.id ) INNER JOIN  twitter_tweet_keywords U3 ON ( U0.id = U3.tweet_id ) INNER JOIN  twitter_keyword U4 ON ( U3.keyword_id = U4.id ) WHERE (U1.country_id = 'NL' %s ) AND NOT (twitter_keyword.id IN (%s))) GROUP BY twitter_keyword.keyword, twitter_keyword.keyword ORDER BY count DESC LIMIT 50;" % (whereclause, excludestring)
        print query
        cursor.execute(query)
        list = cursor.fetchall()
        
        self.items = self.__generate(list, min_font_size, max_font_size)

    def __generate(self, list, min_font_size, max_font_size):
        keyword_map = self.__get_map_from_query_set(list)

        self.largest = self.__get_largest_value_from_map(keyword_map)
        self.smallest = self.__get_smallest_value_from_map(keyword_map)
        
        return self.__generate_item_list(keyword_map, min_font_size, max_font_size, self.smallest)

    def __get_largest_value_from_map(self, a_map):
        if not a_map:
            return 0
        
        key_of_largest_value = max(a_map, key=a_map.get) 
        
        return int(a_map[key_of_largest_value])
    
    def __get_smallest_value_from_map(self, a_map):
        if not a_map:
            return 0
        
        key_of_smallest_value = min(a_map, key=a_map.get) 
        
        return int(a_map[key_of_smallest_value])
    
    def __get_map_from_query_set(self, list):
        keyword_map = {}
        
        for row in list:
            keyword_map[row[0]] = row[1]
            
        return keyword_map
    
    def __get_sum_of_map_values(self, a_map):
        value_sum = 0
        for key in a_map:
            value_sum += int(a_map[key])
            
        return value_sum
    
    def __calculate_font_size_increment(self, occurance, max_font_size, min_font_size):
        if self.smallest == self.largest:
            return 1 # Hack gedoogd door Wytse Visser
        
        return (log(occurance) - log(self.smallest)) / (log(self.largest) - log(self.smallest))
    
    def __calculate_font_size(self, min_font_size, max_font_size, step):
        return round((min_font_size + (max_font_size-min_font_size)*self.step)/min_font_size*100)
    
    def __generate_item_list(self, keyword_map, min_font_size, max_font_size, smallest_value):
        tweet_index_count_array = []
        
        if len(keyword_map) == 0:
            return []
        for item in keyword_map:
            self.step = self.__calculate_font_size_increment(keyword_map[item], max_font_size, min_font_size)
            new_font_size = self.__calculate_font_size(min_font_size, max_font_size, self.step)
            tweet_index_count_array.append(KeywordFontSize(keyword=item, font_scale=new_font_size))
            
        return tweet_index_count_array
    
    def to_json(self):
        return self.items

"""
This class is used to store the font sizes of the given keywords in a cloud
"""
class KeywordFontSize:
    keyword = None
    font_scale = None
    
    def __init__(self, keyword, font_scale):
        self.keyword = keyword
        self.font_scale = font_scale
        
    def __unicode__(self):
        return self.keyword + ": " + str(self.font_scale) + "px"
    
    def to_json(self):
        return {
            'keyword':self.keyword,
            'font_scale':self.font_scale,
        }
        
class BlacklistItem(models.Model):
    keyword = models.ForeignKey(Keyword)
    
    def __unicode__(self):
        return self.keyword.keyword
