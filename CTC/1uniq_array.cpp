#include<iostream>
#include<string.h>
using namespace std;
int main(){
string s;
cin>>s;
int table[26];//assume lower case char

for(int j=0;j<26;j++) 
table[j]=0;

for(int i=0;i<s.length();i++){

if(table[s[i]%97]==0){

table[s[i]%97]=1;
}
else{
cout<<"NO"<<endl;
return 0;
}
}
cout<<"YES"<<endl;
return 0;
}

