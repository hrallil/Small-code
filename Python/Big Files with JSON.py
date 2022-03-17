#%%
import json
import geopy.distance


with open('Cities.json', encoding = 'utf8') as json_file:
    cities = json.load(json_file)
#%%
print(cities[0])

#%% Sweden

se_list = []
for city in cities:
    if city["country"] == "SE":
        se_list.append(city["name"])

se_list.sort()
print(se_list)
# %% ville
ville_list = []

for city in cities:
    if "ville" in city["name"][-6]: 
        ville_list.append(city)

sorted_ville_list = sorted(ville_list, key = lambda city: city["country"])
print(ville_list)
# %% Paris
import geopy.distance
paris_list = []
for city in cities:
    if city["name"] == "Paris" and city["country"] == "FR":
        paris = city
        break

parisPos = (paris["lat"],paris["lng"])
for city in cities:
    cityPos = (city["lat"],city["lng"])
    city["distParis"] = geopy.distance.distance(cityPos, parisPos).km
    if city["distParis"] < 500:
        paris_list.append(city)
print(len(paris_list))
print(cities[0])

# %% Zimbabwe

for city in cities:
    if city["name"] == "Banket" and city["country"] == "ZW" :
        banket = city
        break

maxDistCity = cities[0]

for city in cities:
    if (geopy.distance.distance((city["lat"],city["lng"]), (banket["lat"],banket["lng"]))) > geopy.distance.distance((maxDistCity["lat"],maxDistCity["lng"]), (zimbabwe["lat"],zimbabwe["lng"])):
        maxDistCity = city

print(maxDistCity)
# %%
