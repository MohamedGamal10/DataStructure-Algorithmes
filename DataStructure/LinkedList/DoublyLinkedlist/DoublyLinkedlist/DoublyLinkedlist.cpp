#include <iostream>
using namespace std;
#include "LinkedList.h"

int main()
{
    LinkedList* list = new LinkedList();
    list->insertLast(1);
    list->insertLast(2);
    list->insertLast(3);
    list->printList();

    list->insertAfter(list->find(2), 98);
    list->printList();

    list->deleteNode(list->find(2));
    list->printList();

    list->InsertBefore(list->find(98), 76);
    list->printList();

    /*


    list->deleteNode(list->find(1));
    list->printList();

    cout << "Head: " << list->head->data << "\n";
    */
}
