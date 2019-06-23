/************************************************************************
*
* @description: the main
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

//main.cpp
#include"node.h"
#include<fstream>

void menu()
{
	cout << "请选择" << endl;
	cout << "1. 创建" << endl;
	cout << "2. 添加" << endl;
	cout << "3. 查询" << endl;
	cout << "4. 修改" << endl;
	cout << "5. 删除" << endl;
	cout << "6. 显示" << endl;
	cout << "7. 文件导入" << endl;
	cout << "8. 文件导出" << endl;
	cout << "9. 退出" << endl;
}


void main()
{
	node * listHead = NULL;
	node p;
	int choose, n;
	while (1)
	{
		menu();
		cin>>choose;
		if(choose == 1)
		{
			cout << "请输入几个通讯录:";
			cin >> n;
			if (n > 0)
				listHead = p.chuangjian(n);
		}
		else if (choose == 2)
			p.charu(listHead);
		else if (choose == 3)
			p.find(listHead);
		else if (choose == 4)
			p.xuigai(listHead);
		else if (choose == 5)
			p.shanchu(listHead);
		else if (choose == 6)
			p.display(listHead);
		else if (choose == 7)
		{
			int z,i;
				cout<<"请输入导入人数"<<endl;
				cin>>z;
				string x[100];
				ifstream infile;
				infile.open("tongxunlu.txt",ios::in);
				cout<<" 编号   姓名   性别   年龄   住宅电话   手机号码 "<<endl;
				for(i=0;i<6*z;i++)
				{
					infile>>x[i];
					cout<<"     "<<x[i];
					if((i+1)%6==0)
						cout<<endl;
	   			}
					infile.close();
               p.filein(listHead);
		}
		else if (choose == 8)
			p.fileout(listHead);
		else if (choose == 9)
			break;
}

}
