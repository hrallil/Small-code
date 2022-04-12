#%%
import pickle
from PIL import Image
from datatime import datetime

def someSpecialFunction():
    print("something special")

image = Image.open("images/cat.jpg")
data = {
    "year": datetime.now(),
    "function": someSpecialFunction,
    "image": image

}

#%%
filename = 'data.pkl'
outfile = open(filename,"wb")
pickle.dump(data,outfile)
outfile.close()

#%%