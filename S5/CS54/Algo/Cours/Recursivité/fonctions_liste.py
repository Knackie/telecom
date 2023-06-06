# Nil = []
# list.tail = list[1:]
# list.head = list[0]

# Question 1
def longueur(l):
    if (l == []): 
        return 0
    else: 
        return 1 + longueur(l[1:])

# Question 2
def est_membre(l, v): 
    if (l == []):
        return False
    else:
        if (l[0] == v):
            return True
        else:
            return est_membre(l[1:], v)
   
# Question 3     
def occurence(v, l):
    if (l == []):
        return 0
    else:
        return 1 + occurence(v, l[1:])

# Question 4
def tous_differents(l):
    if (longueur(l) == 1):
        return True
    else:
        if (occurence(l[0], l) != 1):
            return False
        else:
            tous_differents(l[1:])
            
# Question 5
def supprime(v, l):
    if (l == [] or not(est_membre(l, v))):
        return l
    else:
        if (l[0] == v):
            return l[1:].append(supprime(v, l[1:]))
        else:
            return supprime(v, l[1:])
           

if __name__ == '__main__':
    ch = "TelecomNancy"
    l = list(ch)    
    print(est_membre(l, "b"))
                

        
