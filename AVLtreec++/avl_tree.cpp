#include <fstream> 
#include <iostream> 
#include <string> 
#include "avl.h"

using namespace std;

int main(int argc, char * * argv) {
//  cout << argc;
  AVL < string > AS;
  if (argc >= 2) {
    ifstream cin(argv[1]);
    ofstream cout(argv[2]);
    string command;
    while (cin >> command) {
      string input;

      if (command.compare("clear") == 0) {
        cout << "clear" << endl;
        AS.clear();
      }
      else if (command.compare("add") == 0) {
        cin >> input;
       if(AS.Search(input)==0) AS.Insert(input);
        cout << command << " " << input << endl;
      }
      else if (command.compare("remove") == 0) {
        cin >> input;
        AS.Delete(input);
        cout << command << " " << input << endl;
      }
     else if (command.compare("find") == 0) {
        cin >> input;
        cout << command << " " << input << " " << (AS.Search(input)==1?"true":"false") << endl;
      }
     else if (command.compare("print") == 0) {
        cout<<command;
        AS.Print(cout);
        cout<<endl;
      }
	

    }

  }

  return 0;
}
