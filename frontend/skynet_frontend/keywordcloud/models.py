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
    
    def __init__(self, query_set, min_font_size=14, max_font_size=30, num_keywords=20):
        query_set = query_set.all()[:num_keywords]
        self.items = self.__generate(query_set, min_font_size, max_font_size)

    def __generate(self, query_set, min_font_size, max_font_size):
        keyword_map = self.__get_map_from_query_set(query_set)

        self.largest = self.__get_largest_value_from_map(keyword_map)
        self.smallest = self.__get_smallest_value_from_map(keyword_map)
        
        return self.__generate_item_list(query_set, min_font_size, max_font_size, self.smallest)

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
    
    def __get_map_from_query_set(self, the_query_set):
        keyword_map = {}
        for entry in the_query_set:
            keyword_map[entry['keyword']] = entry['count']
            
        return keyword_map
    
    def __get_sum_of_map_values(self, a_map):
        value_sum = 0
        for key in a_map:
            value_sum += int(a_map[key])
            
        return value_sum
    
    def __calculate_font_size_increment(self, occurance, max_font_size, min_font_size):
        if occurance == 1:
            return 0.001 # Hack gedoogd
        
        return (log(occurance)-log(self.smallest))/(log(self.largest)-log(self.smallest));
    
    def __calculate_font_size(self, min_font_size, max_font_size, step):
        return min_font_size + int(round((max_font_size-min_font_size)*self.step));
    
    def __generate_item_list(self, the_query_set, min_font_size, max_font_size, smallest_value):
        tweet_index_count_array = []
        if len(the_query_set) == 0:
            return []
        for row in the_query_set:
            self.step = self.__calculate_font_size_increment(row['count'], max_font_size, min_font_size)
            new_font_size = self.__calculate_font_size(min_font_size, max_font_size, self.step)
            tweet_index_count_array.append(KeywordFontSize(keyword=row["keyword"], font_size=new_font_size))
            
        return tweet_index_count_array
    def to_json(self):
        return self.items

"""
This class is used to store the font sizes of the given keywords in a cloud
"""
class KeywordFontSize:
    keyword = None
    font_size = None
    
    def __init__(self, keyword, font_size):
        self.keyword = keyword
        self.font_size = font_size
        
    def __unicode__(self):
        return self.keyword + ": " + self.font_size + "px"
    
    def to_json(self):
        return {
            'keyword':self.keyword,
            'font_size':self.font_size,
                
        }
