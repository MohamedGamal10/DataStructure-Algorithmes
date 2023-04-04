#pragma once
using namespace std;
#include <iostream>
#include "LinkedListNode.h"
#include "LinkedListIterator.h"
class LinkedList 
{
public:
	LinkedListNode* head = NULL;
	LinkedListNode* tail = NULL;

	//itrator
	LinkedListIterator begin()
	{
		LinkedListIterator itr(this->head);
		return itr;
	}

	//PrintList
	void printList() {

		for (LinkedListIterator itr = this->begin(); itr.current() != NULL; itr.next())
		{
			cout << itr.data() << " -> ";
		}
		cout << "\n";

	}

	//Find
	LinkedListNode *find(int _data) {

		for (LinkedListIterator itr = this->begin(); itr.current() != NULL; itr.next())
		{
			if (_data == itr.data()) 
			{
				return itr.current();
			}
		}
		return NULL;

	}

	//FindParent
	LinkedListNode* findParent(LinkedListNode *node) {

		for (LinkedListIterator itr = this->begin(); itr.current() != NULL; itr.next())
		{
			if (itr.current()->Next == node)
			{
				return itr.current();
			}
		}
		return NULL;
	}



	//Operations
		//InsertLast
	void insertLast(int _data) {
		
		//create node object from new data
		LinkedListNode* newNode = new LinkedListNode(_data);

		//check LinkedList is empty or Not if it empty make newNode is head and tail 
        //else make (tail node next pointer) point to newNode and make newNode is the tail
		if (this->head == NULL) {
			this->head = newNode;
			this->tail = newNode;
		}
		else {
			this->tail->Next = newNode;
			this->tail = newNode;
		}
	}

	//InsertAfter
	void insertAfter(LinkedListNode *node, int _data)
	{
		LinkedListNode* newNode = new LinkedListNode(_data);
		newNode->Next = node->Next;
		node->Next = newNode;

		//if the node that i will add after not have next
		if (this->tail == node) 
		{
			this->tail = newNode;

		}
	}

	//InsertBefore
	void InsertBefore(LinkedListNode* node, int _data)
	{
		LinkedListNode* newNode = new LinkedListNode(_data);
		newNode->Next = node;
		LinkedListNode *parent = this->findParent(node);

		if (parent == NULL) 
		{
			this->head = newNode;
		}
		else
		{
			parent->Next = newNode;
		}
	}

	//Delete
	void deleteNode(LinkedListNode* node)
	{
		if (this->head == this->tail) 
		{
			this->head = NULL;
			this->tail = NULL;
		}
		else if  (this->head == node)
		{
			this->head = node->Next;
		}
		else
		{
			LinkedListNode* parent = this->findParent(node);
			
			if (this->tail ==node) 
			{
				this->tail = parent;
			}
			else
			{
				parent->Next = node->Next;
			}	
		}
		delete node;
	}


};
