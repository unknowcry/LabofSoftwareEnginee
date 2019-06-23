/************************************************************************
*
* @description: the header
*
* @author:      unknowcry
* @date:        2019.06.01
*
* @last modified author:
* @last modified date:
*
* @ copyright unknowcry
*
*************************************************************************/
//node.h
#pragma once
#include<iostream>
#include<string>
#include<iomanip>
#include<fstream>
using namespace std;

class node
{
private:
	string name, tele, mobile;
	int age;
	char sex;
	int num;
	node *next;
public:
	node(void);
	~node(void);

	node * chuangjian(int n);
	void display(node * head);
	node * charu( node * head);
	node * find( node * head);
	node * xuigai( node * head);
	node * shanchu( node * head);
	node * fileout(node * head);
	node * filein(node * head);
};

