
#include<iostream>
#include<string.h>
#include "LinkedList.h"
using namespace std;

template<typename T>
class Node
{
public:
	T value;
	int h; // Height
	Node *left, *right;
};

template<typename T>
class AVL
{
private:
	Node <T> *R, *NIL; // The Root is private to restrict direct access
    int c=0;
public:
	AVL()
	{
		Init(); 
	}

	bool Search(T val)
	{
		return Search(R, val);
	}
	void Insert(T val)
	{
		R = Insert(R, val);
	}

	void Delete(T val)
	{
		R = Delete(R, val);
	}
    void Print(ostream &outputstream){
        Print(R,outputstream);
    }
    void clear(){
       DeallocMemory(R); 
    }
	~AVL()
	{
		DeallocMemory(R);
	}

private:
	void Init()
	{
		R = NIL = new Node<T>;
		NIL->h = 0;
		NIL->left = NIL->right = NULL;
	}

	int Max(int a, int b)
	{
		return a>b ? a : b;
	}


    void Print(Node<T> *N,ostream &cout)
    {
        if (N == NIL) return;

        LinkedList<Node<T>*> queue;
     
        int count=0,cc=0;
        
        Node<T> *dummy;
        dummy = new Node<T>;
		dummy->value = "$$$$$$$$$$$$$";
		dummy->left = dummy->right = NIL;
		dummy->h = 1;
        
        queue.push(dummy);
       
        queue.push(N);
        while(queue.GetListSize() != 0){
            Node<T> *temp=queue.GetHead();
            queue.pop();
             
            if(temp->value==dummy->value){
              
              if(queue.GetListSize()!=0){ queue.push(dummy);
              	cout<<endl<<"level "<<count<<":";
				cc=0;
				count++; 
              }
                
            }
            else{

            //if(temp!=NIL){
			cc++;
			 if(cc==9){
		  	 cout<<endl<<"level "<<(count-1)<<":";
			   cout<<" "<<temp->value<<"("<<temp->h<<")";
			 	cc=1;
			 }else 
			cout<<" "<<temp->value<<"("<<temp->h<<")";
           // }
            if(temp->left!=NIL) queue.push(temp->left);
            if(temp->right!=NIL) queue.push(temp->right);
            
            }
          
        }
        //cout<<endl;   
    }
	void GetHeight(Node<T> *N)
	{
		N->h = 1 + Max(N->left->h, N->right->h);
	}


	bool Search(Node<T> *N, T val)
	{
		if (N == NIL) return false;

		if (N->value == val) return true;

		if (val < N->value)
			return Search(N->left, val);
		else
			return Search(N->right, val);
	}


	Node<T>* Insert(Node<T> *N, T val)
	{  
		if (N == NIL)
		{
			N = new Node<T>;
			N->value = val;
			N->left = N->right = NIL;
			N->h = 1;

			return N;
		}

		if (val <= N->value) N->left = Insert(N->left, val);
		else N->right = Insert(N->right, val);

		return Balance(N);
	}

	Node<T>* Delete(Node<T> *N, T val)
	{
		Node<T> *t;
		if (N == NIL) return N;
		if (N->value == val)
		{
			if (N->left == NIL || N->right == NIL)
			{
				if (N->left == NIL) t = N->right;
				else t = N->left;
				delete N;
				return t;
			}
			else
			{
				for (t = N->right; t->left != NIL; t = t->left);
				N->value = t->value;
				N->right = Delete(N->right, t->value);
				return Balance(N);
			}
		}

		if (val < N->value) N->left = Delete(N->left, val);
		else N->right = Delete(N->right, val);

		return Balance(N);
	}

	Node<T>* RotateLeft(Node<T> *N)
	{
		Node<T> *t = N->left;
		N->left = t->right;
		t->right = N;
		GetHeight(N);
		GetHeight(t);

		return t;
	}

	Node<T>* RotateRight(Node<T> *N)
	{
		Node<T> *t = N->right;
		N->right = t->left;
		t->left = N;
		GetHeight(N);
		GetHeight(t);

		return t;
	}


	Node<T>* Balance(Node<T> *N)
	{
		GetHeight(N);

		if (N->left->h > N->right->h + 1)
		{
			if (N->left->right->h > N->left->left->h)
				N->left = RotateRight(N->left);
			N = RotateLeft(N);
		}
		else
		if (N->right->h > N->left->h + 1)
		{
			if (N->right->left->h > N->right->right->h)
				N->right = RotateLeft(N->right);
			N = RotateRight(N);
		}

		return N;
	}
    
	// Recursively destroys the tree
	void DeallocMemory(Node<T> *N)
	{
		if (N == NIL) return;
		DeallocMemory(N->left);
		DeallocMemory(N->right);
		delete N;
	}
};
