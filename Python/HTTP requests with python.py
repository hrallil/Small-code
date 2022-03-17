#%%
import requests
import json

#%%
parameter = {"query": "Copenhagen"}
r = requests.get(url = "https://www.metaweather.com/api/location/search/", params=parameter)

response = r.json()
print(response)
#%%

r = requests.get(url = "https://www.metaweather.com/api/location/" + str(response[0]['woeid']))

response = r.json()

response
# %%
