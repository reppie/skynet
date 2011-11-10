from skynet_frontend.twitter.models import Keyword
from skynet_frontend.keywordcloud.models import BlacklistItem

keywords = ['jaa', 'at', 'jij', 'het', 'niet', 'wil', 'een', 'vind', 'ik', 'mij', 'even', 'nee', 'heb', 'met', 'uit', 'zo', 'van', 'voor', 'doe', 'de', 'hoe', 'we', 'er', 'dat', 'dan', 'je', 'moet', 'ben', 'maken', 'en', 'gaan', 'aan', 'me', 'heeft', 'hebben', 'echt', 'al', 'wat', 'is', 'nou', 'weer', 'weet', 'of', 'nog', 'net', 'als', 'over', 'anders', 'wel', 'tot', 'the', 'on', 'ja', 'gaat', 'na', 'nu', 'op', 'mn', 'in', 'kan', 'hem', 'oke', 'ff', 'bij', 'dit', 'ook', 'die', 'ok', 'veel', 'rt', 'helemaal', 'mee', 'geen', 'zin', 'meer', 'deze', 'naar', 'om', 'te', 'mijn', 'to', 'he', 'up', 'kom', 'and', 'you', 'kijken', 'pas', 'want', 'was', 'hele', 'dus', 'for', 'zit', 'waar', 'bent', 'ze', 'daar', 'zie', 'doen', 'zijn', 'kk', 'bijna', 'had', 'zou', 'komen', 'ga', 'mag', 'gedaan', 'man', 'maar', 'im', 'hoor', 'toch', 'heel', 'hij', 'xd', 'denk', 'komt', 'it', 'gwn', 'iets', 'tegen', 'oh', 'zal', 'dingen', 'door', 'no', 'wie', 'worden', 'wij', 'so', 'egt', 'ene', 'weten', 'ging', 'gs', 'dacht', 'nie', 'per', 'ie', 'welke', 'ofzo', 'zelf']
for word in keywords:
    keyword = Keyword.objects.get_or_create(keyword=word)[0]
    keyword.save()
    blacklistitem = BlacklistItem(keyword=keyword)
    blacklistitem.save()
