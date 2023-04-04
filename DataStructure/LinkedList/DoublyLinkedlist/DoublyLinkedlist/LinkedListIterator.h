#pragma once
#include "LinkedListNode.h"
class LinkedListIterator
{
public:
	LinkedListNode* currentNode;

	LinkedListIterator()
	{
		currentNode = NULL;
	}

	LinkedListIterator(LinkedListNode* node)
	{
		currentNode = node;
	}

	int data()
	{
		return this->currentNode->data;
	}

	LinkedListIterator next()
	{
		this->currentNode = this->currentNode->Next;
		return *this;
	}

	LinkedListNode* current()
	{
		return this->currentNode;

	}

};


