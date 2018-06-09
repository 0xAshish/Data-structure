#include <fstream> 
#include <iostream> 
#include <string.h> 
#include "hashtable.h"
using namespace std;

int main(int argc, char * * argv) {
    HashTable< string > Ht;
  

   if (argc >= 2) {
     ifstream cin(argv[1]);
      ofstream cout(argv[2]);
    string command;
    while (cin >> command) {
      string input;

      if (command.compare("clear") == 0) {
        cout << "clear" << endl;
        Ht.clear();
      }
      else if (command.compare("add") == 0) {
        cin >> input;
       if(Ht.Search(input)==0) Ht.Insert(input);
        cout << command << " " << input << endl;
      }
      else if (command.compare("remove") == 0) {
        cin >> input;
        if(Ht.Search(input)!=0) Ht.Delete(input);
        cout << command << " " << input << endl;
      }
     else if (command.compare("find") == 0) {
        cin >> input;
        cout << command << " " << input << " " << (Ht.Search(input)==1?"true":"false") << endl;
      }
     else if (command.compare("print") == 0) {
        cout<<command<<endl;
        Ht.Print(cout);
      }
	

    }

 }    

      return 0;
}
