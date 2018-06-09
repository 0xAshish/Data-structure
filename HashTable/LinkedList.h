#pragma once
#include <string>
#include <iostream>
#include <fstream>
#include <sstream>

using namespace std;

template<typename T>

class LinkedList
{
private:
	struct qnode {
		int index = 0;
		T data;
		qnode* next = NULL;
		qnode* prev = NULL;
	};
	int listSize;
	qnode* head = NULL;
	qnode* tail = NULL;
	qnode* curr = NULL;
	qnode* temp = NULL;
	stringstream outputData;

public:
	LinkedList() {
		listSize = 0;
		head = NULL;
		tail = NULL;
	}
	void ClearList() {
		curr = head;
		temp = head;
		outputData << "clear" << '\n';
		while (temp != NULL) {
			temp = curr->next;
			delete curr;
			curr = temp;
		}

		head = NULL;
		tail = NULL;
		curr = NULL;
		temp = NULL;

	}
	void EndClear() {
		curr = head;
		temp = head;

		while (temp != NULL) {
			temp = curr->next;
			delete curr;
			curr = temp;
		}


	}
	void InsertNode(int insertIndex, T data) {

		//if the index is valid
		if (insertIndex <= listSize) {
			qnode* n = new qnode;
			n->data = data;
			listSize++;

			//if the list is empty
			if (head == NULL) {
				head = n;
				tail = n;
				n->next = NULL;
				n->prev = NULL;
			}
			//the list is not empty
			else {
				FindInsertIndex(insertIndex);

				//curr & temp are now in place

				//link the inserted item
				n->next = curr;
				n->prev = temp;


				//link surrounding items

				//if not inserted at index 0
				if (temp != NULL) {
					temp->next = n;
				}
				else {
					head = n;
				}

				//if not inserted at end of list
				if (curr != NULL) {
					curr->prev = n;
				}
				else {
					tail = n;
				}

				UpdateIndices(n);
			}
		}
		//Index is invalid
		else {
			cout << "Invalid size error detected (delete this line before passing off)" << endl;
		}
		outputData << "insert " << insertIndex << " " << data << '\n';

	}
	void RemoveNode(int removeIndex) {
		bool found = false;
		curr = head;
		while (!found && curr != NULL) {
			if (curr->index == removeIndex) {
				found = true;
			}
			else {
				curr = curr->next;
			}
		}
		outputData << "remove " << removeIndex;
		if (found) {

			outputData << " " << curr->data;

			temp = curr->prev;

			//check if first item is being deleted
			if (temp != NULL) {
				temp->next = curr->next;
				if (temp->next != NULL) {
					temp = temp->next;
					temp->prev = curr->prev;
				}
			}
			else {
				temp = curr->next;
				if (temp != NULL) {
					temp->prev = NULL;
					head = temp;
				}
				else {
					head = NULL;
					tail = NULL;
				}
			}


			delete curr;
			listSize--;
			UpdateIndices(temp);
		}

		outputData << '\n';

	}
	int FindNode(T search) {
		bool found = false;
		int foundIndex = -1;
		curr = head;
		while (!found && curr != NULL) {
			if (curr->data == search) {
				found = true;
				foundIndex = curr->index;
			}
			else {
				curr = curr->next;
			}
		}

		string output;
		outputData << "find " << search << " " << foundIndex << '\n';


		return foundIndex;

	}
	void PrintList(ostream &cout) {
		curr = head;
		int counter = 0;
		outputData << "print" << '\n';
		while (curr != NULL) {
			//outputData << "node " << counter << ": " << 
			cout<<" "<<curr->data;
			counter++;
			curr = curr->next;
		}

	}
	void OutputData(string filename) {
		ofstream fout;
		fout.open(filename);
		if (fout.is_open()) {
			fout << outputData.str();
		}

	}
	void UpdateIndices(qnode* n) {

		curr = n;
		while (curr != NULL) {
			temp = curr->prev;
			//if there is no previous item, the index must be 0
			if (temp == NULL) {
				curr->index = 0;
			}
			else {
				curr->index = temp->index + 1;
			}
			if (curr->next == NULL)
			{
				tail = curr;
			}
			curr = curr->next;


		}

	}
	void FindInsertIndex(int insertIndex) {
		//if index is closer to head
		if (insertIndex < listSize / 2) {
			curr = head;
			//while current pointer isn't at the insertion index
			while (curr->index != insertIndex) {
				//proceed to next next item
				curr = curr->next;
			}
			temp = curr->prev;
		}


		//index is closer to tail
		else {
			curr = tail;

			//if insertion point is empty space after list
			if (curr->index < insertIndex) {
				temp = tail;
				curr = NULL;
			}

			else {

				//while current pointer isn't at the insertion index
				while (curr->index != insertIndex) {
					//reverse to the previous item
					curr = curr->prev;
				}
				temp = curr->prev;
			}
		}

	}
	void push(T data) {

		qnode* n = new qnode;
		n->data = data;
		listSize++;
		//if the list is empty
		if (head == NULL) {
			head = n;
			tail = n;
			n->next = NULL;
			n->prev = NULL;
		}
		//the list is not empty
		else {
			FindInsertIndex(listSize);
			//curr & temp are now in place
			//link the inserted item
			n->next = curr;
			n->prev = temp;
			//link surrounding items
			//if not inserted at index 0
			if (temp != NULL) {
				temp->next = n;
			}
			else {
				head = n;
			}
			//if not inserted at end of list
			if (curr != NULL) {
				curr->prev = n;
			}
			else {
				tail = n;
			}
			UpdateIndices(n);
		}
	}
	void pop() {

		curr = head;
		temp = curr->next;
		if (temp != NULL) {
			temp->prev = NULL;
			head = temp;
		}
		else {
			head = NULL;
			tail = NULL;
		}


		delete curr;
		listSize--;
		UpdateIndices(temp);
	}

	int GetListSize() {
		return listSize;
	}
	T GetHead() {
		return head->data;
	}


};

