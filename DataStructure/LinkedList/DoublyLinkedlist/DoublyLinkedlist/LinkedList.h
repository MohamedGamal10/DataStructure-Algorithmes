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
	LinkedListNode* find(int _data) {

		for (LinkedListIterator itr = this->begin(); itr.current() != NULL; itr.next())
		{
			if (_data == itr.data())
			{
				return itr.current();
			}
		}
		return NULL;

	}



	//Operations
		//InsertLast
	void insertLast(int _data) 
	{
		LinkedListNode* newNode = new LinkedListNode(_data);
		if (this->tail == NULL)
		{
			this->head = newNode;
			this->tail = newNode;
		}
		else
		{
			newNode->Back = this->tail;
			this->tail->Next = newNode;
			this->tail = newNode;
		}
	}

	//InsertAfter
	void insertAfter(LinkedListNode* node, int _data)
	{
		LinkedListNode* newNode = new LinkedListNode(_data);
		newNode->Next = node->Next;
		newNode->Back = node;
		node->Next = newNode;

		if (newNode->Next == NULL) 
		{
			this->tail = newNode;
		}
		else
		{
			newNode->Next->Back = newNode;
		}
		
	}

	//InsertBefore
	void InsertBefore(LinkedListNode* node, int _data)
	{
		LinkedListNode* newNode = new LinkedListNode(_data);
		newNode->Next = node;

		if (node == this->head)
		{
			this->head = newNode;
		}
		else
		{
			node->Back->Next = newNode;
		}
		node->Back = newNode;
	}

	//Delete
	void deleteNode(LinkedListNode* node)
	{
		if (this->head == this->tail)
		{
			this->head = NULL;
			this->tail = NULL;
		}
		else if (node->Back == NULL)
		{
			this->head = node->Next;
			node->Next->Back = NULL;
		}
		else if (node->Next == NULL)
		{
			this->tail = node->Back;
			node->Back->Next = NULL;
		}
		else 
		{
			node->Back->Next = node->Next;
			node->Next->Back = node->Back;
		}

		delete node;
		
	}


};
