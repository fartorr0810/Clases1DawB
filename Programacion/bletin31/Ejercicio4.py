'''
Created on 30 nov. 2020

@author: fran
4. Design a method called dayOfWeek that receives three integer parameters: day, month and year. The method should return a number between 0 and 6 that is the day in the week for that date. You have to know the next algorithm:
       
       a = (14 - month) / 12 
       y = year – a 
       m = month + 12 * a – 2 
       d = (day + y + y/4 - y/100 + y/400 + (31*m)/12) mod 7
       
       If the variable d is zero was Sunday, 1 Monday……………... 6 Saturday. 
       
'''