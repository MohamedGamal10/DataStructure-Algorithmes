#pragma once
#include <cstddef>
class LinkedListNode
{
public:
	int data;
	LinkedListNode* Next;
	LinkedListNode* Back;

	//Constructor
	LinkedListNode(int _data) {
		this->data = _data;
		this->Next = NULL;
		this->Back = NULL;

	}
};

