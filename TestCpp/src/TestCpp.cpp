//============================================================================
// Name        : TestCpp.cpp
// Author      : kobae964
// Version     :
// Copyright   : 
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
#include <cstdio>
#include <vector>
#include <valarray>
#include <windows.h>
using namespace std;

int main(int argc,char **argv) {
	MessageBoxA(0,"b","c",0);
	puts("test");
	std::valarray<int> a(2);
	a.resize(2,1);
	a[0]=3;
	a+=3;
	for(size_t i=0;i<a.size();i++)
	{
		printf("%d ",a[i]);
	}
	return 0;
}
