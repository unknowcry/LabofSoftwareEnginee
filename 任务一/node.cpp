/************************************************************************
*
* @description: the cpp
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
//node.cpp
#include "node.h"


node::node(void)
{
}


node::~node(void)
{
}


node * node:: chuangjian(int n)
{
	node *temp, *tail = NULL, *head = NULL ;
	string na, t, m;
	char s;
	int nu, a;
	cout<<"请输入"<< n <<"个人的编号，姓名，性别，年龄，宅电，手机："<<endl;
	cin >> nu >> na >> s >> a >> t >> m;
	head = new node ;
	if (head == NULL)
	{
		cout << "No memory available!"<<endl;
		return NULL;
	}
	else
	{
		head->num = nu;
		head->name = na;
		head->sex = s;
		head->age = a;
		head->tele = t;
		head->mobile = m;
		head->next = NULL;
		tail = head;
	}

	for ( int i = 0; i < n-1 ; i ++)
	{
		cin >> nu >> na >> s >> a >> t >> m;
		temp = new node ;
		if (temp == NULL)
		{
			cout << "No memory available!"<<endl;
			return head;
		}
		else
		{
			temp->num = nu;
			temp->name = na;
			temp->sex = s;
			temp->age = a;
			temp->tele = t;
			temp->mobile = m;
			temp->next = NULL;
			tail->next = temp;
			tail = temp;
		}
	}

	return head ;
}

void node::display(node * head)
{
	cout << "通讯录: "<<endl;
	node *curNode = head;

	while (curNode)
	{
		cout << curNode->num<<"     "<< curNode->name<<"     "<<
			curNode->sex<<"     "<< curNode->age<<"     "<<
			curNode->tele<<"     "<< curNode->mobile;
		if (curNode ->next)
			cout << endl;
		curNode = curNode ->next;
	}

	cout << endl;
}

node * node:: charu( node * head)
{
	int n;
	cout<<"请插入编号:"<<endl;
	cin>>n;
	string na,t,m;
	char s;
	int a;
	node *curNode = head;
	node *preNode = NULL;
	node *newNode = NULL;

	while ((curNode!=NULL)&&(curNode->num<n))
	{
		preNode = curNode;
		curNode = curNode->next;
	}

	newNode = new node ;
	if (newNode == NULL)
	{
		cout << "No memory available!";
		return head;
	}
	cout<<"请输入姓名，性别，年龄，住宅电话，手机："<<endl;
	cin>>na>>s>>a>>t>>m;
	newNode->num = n;
	newNode->name = na;
	newNode->sex = s;
	newNode->age = a;
	newNode->tele = t;
	newNode->mobile = m;

	if (preNode == NULL)
	{
		newNode->next = curNode;
		return newNode;
	}
	else
	{
		preNode->next = newNode;
		newNode->next = curNode;
		return head;
	}

}

node * node:: find( node * head)
{
	string n;
	cout<<"请输入需要查询的姓名或手机："<<endl;
	cin>>n;
	cout<<endl;
	node *curNode = head;
	while ( curNode )
	{
		if ( curNode->name == n||curNode->mobile==n)
		{
			cout<<"Find "<<n<<" in the list."<<endl;
			cout<<"详细信息为："<<endl;
			cout << curNode->num<<"     "<< curNode->name<<"     "<<curNode->sex<<"     "<< curNode->age<<"     "<< curNode->tele<<"     "<< curNode->mobile;
			return curNode;
		}
		curNode = curNode->next;
	}

	cout<<"Can't find "<<n<<" in the list."<<endl;
	return NULL;
}

node* node::xuigai(node *head)
{

	string na,t,m;
	char s;
	int a;
	int nu, p=1;
	cout<<"请输入需要修改的姓名："<<endl;
	cin>>na;
	cout<<endl;
	node *curNode = head;
	while ( curNode )
	{
		if ( curNode->name == na)
		{
			cout<<"Find "<<na<<" in the list."<<endl;
			cout<<"请重新修改信息："<<endl;
			cin>>nu>>na>>s>>a>>t>>m;
			curNode->num = nu;
				curNode->name =na;
				curNode->sex  =s;
				curNode->age  =a;
				curNode->tele =t;
				curNode->mobile =m;
			p=2;
			return curNode;
		}
		curNode = curNode->next;
	}

	if(p==1)
	cout<<"Can't find "<<na<<" in the list."<<endl;
	return NULL;

}

node * node:: shanchu( node * head)
{
	string na,se,ag,te,ph;
	cout<<"请输入要删除的名字：";
	cin>>na;
	node *curNode = head;
	node *preNode = NULL;
	while (curNode && curNode->name != na)
	  {
		  preNode = curNode;
		  curNode = curNode->next;
	  }

	  if (curNode == NULL)
	  {
		  cout<<"Can't find "<<na<<" in the list"<<endl;
		  return head;
	  }
	  if (preNode == NULL)
	  { head = head->next;cout<<"已成功删除";}
	  else
		  preNode->next = curNode->next;

	  delete curNode;
	  return head;
}

node * node::filein(node * head)
{
				int z,i;
				cout<<"请输入导入人数"<<endl;
				cin>>z;
				string x[100];
				ifstream infile;
				infile.open("tongxunlu.txt",ios::in);
				cout<<" 编号 姓名 性别 年龄 宅电 手机号码 "<<endl;
				for(i=0;i<6*z;i++)
				{
					infile>>x[i];
					cout<<"   "<<x[i];
					if((i+1)%6==0)
						cout<<endl;
	   			}
					infile.close();
					return 0;
}

node * node:: fileout( node * head)
{
	int n;
	   ofstream outfile ("tongxunlu.txt",ios::out);
         if(!outfile)
         {
	       cerr<<"open error!"<<endl;
           exit(1);
         }
            cout<<"请输入几个信息："<<endl;
            cin >> n ;
             cout<<endl;
	string	number,name,sex,age,telephone,phone;

	node *curNode = head;
	while (curNode)
	{
		outfile << curNode->num<<"     "<< curNode->name<<"     "<<curNode->sex<<"     "<< curNode->age<<"     "<< curNode->tele<<"     "<< curNode->mobile<<endl;;
		if (curNode ->next)
			cout << endl;
		curNode = curNode ->next;
	}
}

