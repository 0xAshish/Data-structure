import time
import random, string
# a python hashtable implementation by ashish_rp7
# hash_key supports string, can be modified to support other data types

class hash:
    table = []
    size = 0
    resize_count = 0
    def __init__(self, n=10):
        self.size = 0
        self.table = ['$']*n

    def hash_key(self, string_value):
        hash = 31
        n = len(self.table)
        for i in string_value:
            hash = (((hash<<3)+hash)%n)+ord(i)
            hash %= n
        return hash

    # def hash_key(self, string_value): another version
    # which is in java hashtable for string
    #     hash = 33
    #     n = len(self.table)
    #     for i in string_value:
    #         hash = (((hash<<5)+hash)%n)+ord(i)
    #         hash %= n
    #     return hash

    def insert(self, string_value):
        if self.size > int(len(self.table)*0.90):
            self.resize()
        key = self.hash_key(string_value)
        self.size += 1
        if self.table[key] == string_value:
            return
        if self.table[key]=='$':
            self.table[key] = string_value
        elif isinstance(self.table[key], basestring):
            item1 = self.table[key]
            self.table[key] = [item1, string_value]
        else:
            self.table[key].append(string_value)

    def find(self, string_value):
        key = self.hash_key(string_value)
        if self.table[key]=='$':
            return False
        if isinstance(self.table[key], basestring):
            return True
        return string_value in self.table[key]

    def resize(self):
        prev_table = self.table
        self.size = 0
        self.resize_count += 1
        self.table = ['$']*(len(self.table)*2)
        for item in prev_table:
            if isinstance(item,list):
                for item_ in item:
                    self.insert(item_)
            elif item !='$':
                self.insert(item)

    def print_all(self):
        for item in self.table:
            if isinstance(item,list):
                for item_ in item:
                    print(item_)
            elif item !='$':
                print(item)



# testing releted code
def randomword(length):
   letters = string.ascii_letters
   return ''.join(random.choice(letters) for i in range(length))

hashtable = hash(50)

mywords = []

for i in range(5000):
    word = randomword(10)
    hashtable.insert(word)
    mywords.append(word)
    if not hashtable.find(word):
        raise Exception('HashTable is fraud')

print("Current Size of HashTable:", hashtable.size)
print("HashTable resize:"+str(hashtable.resize_count)+"times")
for i in range(10):
    item = random.choice(mywords)
    t1 = time.time()
    hashtable.find(item)
    t2 = time.time()
    print(t2-t1)