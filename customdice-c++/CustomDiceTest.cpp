#include "CustomDice.h"
#include <iostream>

using std::cerr;
using std::cout;
using std::endl;

class CustomDiceTest {

    static void assertEquals(int testCase, const int& expected, const int& actual) {
        if (expected == actual) {
            cout << "Test case " << testCase << " PASSED!" << endl;
        } else {
            cout << "Test case " << testCase << " FAILED! Expected: <" << expected << "> but was: <" << actual << '>' << endl;
        }
    }

    CustomDice solution;

    void testCase0() {
		int M = 3;
		int expected_ = 0;
        assertEquals(0, expected_, solution.countDice(M));
    }

    void testCase1() {
		int M = 4;
		int expected_ = 210;
        assertEquals(1, expected_, solution.countDice(M));
    }

    void testCase2() {
		int M = 10;
		int expected_ = 863010;
        assertEquals(2, expected_, solution.countDice(M));
    }

    void testCase3() {
		int M = 50;
		int expected_ = 375588112;
        assertEquals(3, expected_, solution.countDice(M));
    }

    public: void runTest(int testCase) {
        switch (testCase) {
            case (0): testCase0(); break;
            case (1): testCase1(); break;
            case (2): testCase2(); break;
            case (3): testCase3(); break;
            default: cerr << "No such test case: " << testCase << endl; break;
        }
    }

};

int main() {
    for (int i = 0; i < 4; i++) {
        CustomDiceTest test;
        test.runTest(i);
    }
}
