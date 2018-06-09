#include<iostream>
#include<string.h>
#include <cmath> 
#include "LinkedList.h"
using namespace std;

template<typename T>
class HashTable
{
private:
	LinkedList<T> *HT;
    int c=1;
    int items=0;
public:
	HashTable()
	{
		Init(); 
	}
    void Print(ostream &out)
    {   
        if(items>0){
          for(int i=0;i<c;i++){     
                  out<<"hash "<<i<<":";
                  HT[i].PrintList(out);
                  out<<endl;
              
          }
          }
          
        
    }

	bool Search(T val)
	{   
           int index=hashCode(val,c);
             if(HT[index].GetListSize()>0)
             {
                int ind=HT[index].FindNode(val);
                return (ind>=0)?true:false;
             }
             else return false;
             
	}

    bool Full()
    {
        return abs(items-c)==0;
    }

    bool Empty()
    {   
        int empty=c/2;
        return items<=empty;
    }

	bool Insert(T val)
	{   
        if(Full())
        {   
            int size=c*2+1;
            items=0;
            reHash(size);
            c=size;
        }
        int index=hashCode(val,c);
        //cout<<index<<endl;
        HT[index].push(val);
        items++;
      
        
        return true;
	}

    void reHash(int size)
    {
        LinkedList<T> *newTable=new LinkedList<T>[size];
        for(int i=0;i<c;i++)
        {
            while(HT[i].GetListSize()!=0)
            {
                T temp=HT[i].GetHead();
                HT[i].pop();
                int index=hashCode(temp,size);
                newTable[index].push(temp);
                items++;
                
            }
        }
 
        delete[] HT;
        HT=newTable;

    }
	void Delete(T val)
	{   items--;
        int index=hashCode(val,c);
        int ind=HT[index].FindNode(val);
       // cout<<ind<<"index del"<<endl;
        if(ind>=0){ HT[index].RemoveNode(ind);    }

        if(Empty()&&c>1){
           // cout<<"empty";
            int size=(c-1)/2;
            items=0;
            reHash(size);
            c=size;
 
        }
	}
    void clear()
    {
       DeallocMemory(); 
       Init();
    }
	~HashTable()
	{
		DeallocMemory();
	}

private:
	void Init()
	{   
		HT= new LinkedList<T>[c];
	}

    unsigned hashCode( const string s ,int mod) 
    {
        unsigned HashIndex=0;
        for(int i = 0; i<s.length(); i++) {
            HashIndex*=31;
            HashIndex+=s[i];
    
        }
        return HashIndex%mod;
    }
	// Recursively destroys the table
	void DeallocMemory()
	{
		delete[] HT;
	}
};
