#%%
from ast import For
import json

with open('PhoneBook.json', encoding = 'utf8') as json_file:
    phoneNumbersJSON = json.load(json_file)
#%%
phoneNumbers = []
#%%
def add():
    print("Sirname:")
    sirname = input()
    print("Lastname")
    lastname = input()
    print("phone number:")
    number = input()

    newEntry = {
        "sirName": sirname,
        "lastName": lastname,
        "phoneNumber": number 
    }
    if newEntry not in phoneNumbers:
        phoneNumbers.append(newEntry)
    else:
        print("Error: Person is already in the phonebook")

def printPhoneBook():
    print(phoneNumbers)

def printHelp():
    print("list of commands: \n")
    print("-help: shows all inputvalues")
    print("-quit: quits the main loop")
    print("-add: adds a new entry to the phonebook")
    print("-show: shows the phonebook")

#%%
running = True
while(running):
    userInput = input()
    if userInput == "quit":
        userInput = ""
        running = False
    elif userInput == "add":
        userInput = ""
        add()
    elif userInput == "help":
        userInput = ""
        printHelp()
    elif userInput == "show":
        userInput = ""
        printPhoneBook()
        
    else:
        userInput = ""
        print("ERROR: not a command!")
        


# %%
