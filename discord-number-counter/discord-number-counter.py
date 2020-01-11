from keyboard import write
from keyboard import press_and_release
from time import sleep
wordInput = input("Please put the starting number between 10000 and 99999: ")
sleep(2)
for x in range (0,50):
    # This code right here is because the first 2 and last 2 are counted together ( Ex: Ten thousand, Thirty nine )
    # But the middle digit is counted on itself ( One hundred, Three Hundred )
    Dob1 = wordInput[0] + wordInput[1]
    Dob2 = wordInput[3] + wordInput[4]
    if Dob1 == "11":
        Endresult = "Eleven thousand "
    elif Dob1 == "12":
        Endresult = "Twelve thousand "
    elif Dob1 == "13":
        Endresult = "Thirteen thousand "
    elif Dob1 == "14":
        Endresult = "Fourteen thousand "
    elif Dob1 == "15":
        Endresult = "Fifteen thousand "
    elif Dob1 == "16":
        Endresult = "Sixteen thousand "
    elif Dob1 == "17":
        Endresult = "Seventeen thousand "
    elif Dob1 == "18":
        Endresult = "Eighteen thousand "
    elif Dob1 == "19":
        Endresult = "Nineteen thousand "
    elif Dob1 == "10":
        Endresult = "Ten thousand "
    elif wordInput[0] == "2":
        Endresult = "Twenty "
    elif wordInput[0] == "3":
        Endresult = "Thirteen "
    elif wordInput[0] == "4":
        Endresult = "Fourty "
    elif wordInput[0] == "5":
        Endresult = "Fifty "
    elif wordInput[0] == "6":
        Endresult = "Sixty "
    elif wordInput[0] == "7":
        Endresult = "Seventy "
    elif wordInput[0] == "8":
        Endresult = "Eighty "
    elif wordInput[0] == "9":
        Endresult = "Ninety "
    if wordInput[0] != "1":
        if wordInput[1] == "1":
            Endresult = Endresult + "One thousand "
        elif wordInput[1] == "2":
            Endresult = Endresult + "Two thousand "
        elif wordInput[1] == "3":
            Endresult = Endresult + "Three thousand "
        elif wordInput[1] == "4":
            Endresult = Endresult + "Four thousand "
        elif wordInput[1] == "5":
            Endresult = Endresult + "Five thousand "
        elif wordInput[1] == "6":
            Endresult = Endresult + "Six thousand "
        elif wordInput[1] == "7":
            Endresult = Endresult + "Seven thousand "
        elif wordInput[1] == "8":
            Endresult = Endresult + "Eight thousand "
        elif wordInput[1] == "9":
            Endresult = Endresult + "Nine thousand "
    if wordInput[2] == "1":
        Endresult = Endresult + "One hundred "
    elif wordInput[2] == "2":
        Endresult = Endresult + "Two hundred "
    elif wordInput[2] == "3":
        Endresult = Endresult + "Three hundred "
    elif wordInput[2] == "4":
        Endresult = Endresult + "Four hundred "
    elif wordInput[2] == "5":
        Endresult = Endresult + "Five hundred "
    elif wordInput[2] == "6":
        Endresult = Endresult + "Six hundred "
    elif wordInput[2] == "7":
        Endresult = Endresult + "Seven hundred "
    elif wordInput[2] == "8":
        Endresult = Endresult + "Eight hundred "
    elif wordInput[2] == "9":
        Endresult = Endresult + "Nine hundred "
    if Dob2 == "11":
        Endresult = Endresult + "and Eleven"
    elif Dob2 == "12":
        Endresult = Endresult + "and Twelve"
    elif Dob2 == "13":
        Endresult = Endresult + "and Thirteen"
    elif Dob2 == "14":
        Endresult = Endresult + "and Fourteen"
    elif Dob2 == "15":
        Endresult = Endresult + "and Fifteen"
    elif Dob2 == "16":
        Endresult = Endresult + "and Sixteen"
    elif Dob2 == "17":
        Endresult = Endresult + "and Seventeen"
    elif Dob2 == "18":
        Endresult = Endresult + "and Eighteen"
    elif Dob2 == "19":
        Endresult = Endresult + "and Nineteen"
    elif Dob2 == "10":
        Endresult = Endresult + "and Ten"
    elif wordInput[3] == "2":
        Endresult = Endresult + "and Twenty "
    elif wordInput[3] == "3":
        Endresult = Endresult + "and Thirty "
    elif wordInput[3] == "4":
        Endresult = Endresult + "and Fourty "
    elif wordInput[3] == "5":
        Endresult = Endresult + "and Fifty "
    elif wordInput[3] == "6":
        Endresult = Endresult + "and Sixty "
    elif wordInput[3] == "7":
        Endresult = Endresult + "and Seventy "
    elif wordInput[3] == "8":
        Endresult = Endresult + "and Eighty "
    elif wordInput[3] == "9":
        Endresult = Endresult + "and Ninety "
    elif Dob2 != "00" and wordInput[3] == "0":
        Endresult = Endresult + "and "
    if wordInput[3] != "1":
        if wordInput[4] == "1":
            Endresult = Endresult + "One"
        elif wordInput[4] == "2":
            Endresult = Endresult + "Two"
        elif wordInput[4] == "3":
            Endresult = Endresult + "Three"
        elif wordInput[4] == "4":
            Endresult = Endresult + "Four"
        elif wordInput[4] == "5":
            Endresult = Endresult + "Five"
        elif wordInput[4] == "6":
            Endresult = Endresult + "Six"
        elif wordInput[4] == "7":
            Endresult = Endresult + "Seven"
        elif wordInput[4] == "8":
            Endresult = Endresult + "Eight"
        elif wordInput[4] == "9":
            Endresult = Endresult + "Nine"
    #Writes the number
    write(wordInput)
    #Delay put to avoid Discord from Lagging
    sleep(0.3)
    #Puts a spacing in between
    write("   ")
    sleep(0.3)
    #Writes the number in text.
    write(Endresult)
    sleep(0.3)
    press_and_release("enter")
    sleep(0.5)
    #Increases the number by 1, while keeping it as a string.
    wordInput = int(wordInput)
    wordInput = wordInput + 1
    wordInput = str(wordInput)


