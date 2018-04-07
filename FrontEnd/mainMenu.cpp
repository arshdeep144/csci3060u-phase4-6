#include <fstream>
#include <iostream>
#include <limits>
#include <string>
#include <list>
#include <iterator>
#include "mainMenu.hpp" 
#include "advertiseItem.hpp"
#include "deleteUser.hpp"
#include "Users.hpp"
#include "Logout.hpp"
#include "createUser.hpp"
#include "addCredit.hpp"
#include "refundCredit.hpp"
#include "bidItem.hpp"


/*
 *If login successful, redirect to main_menu. 
 *This function has access to all commands except login. 
 *TODO all commands, any command currently input terminates session.
 */



void mainMenu::main_menu()
{
    advertiseItem a;
    bidItem b;
    deleteUser d;
    Logout l;
    createUser c;
    addCredit ac;
    refundCredit rc;

    std::string userCommand;
    std::cout << "Welcome to the main menu. Please enter a command to continue: " << "\n";
    std::cin >> userCommand;

    if (userCommand == "advertise")
    {
        a.advertise_item();
    }
    else if (userCommand == "bid")
    {
        b.bid_item();
    }
    else if (userCommand == "addcredit")
    {
        ac.add_credit();
    }
    else if (userCommand == "refundcredit")
    {
        rc.refund_credit();
    }   
    else if (userCommand == "deleteuser")
    {
        d.delete_user();
    }
    else if (userCommand == "createuser")
    {
        c.create_user();
    }
    else if (userCommand == "logout")
    {
        l.logout();
    }
    else 
    {
        std::cout << "Command not Recognized" << "\n";
    }
}
