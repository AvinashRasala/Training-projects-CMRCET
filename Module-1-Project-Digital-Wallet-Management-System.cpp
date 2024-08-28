#include <bits/stdc++.h>
using namespace std;

struct UserAccount
{
    int id;
    int funds;
};

bool sortByFunds(const UserAccount &a, const UserAccount &b)
{
    if (a.funds == b.funds)
        return a.id < b.id;
    return a.funds < b.funds;
}

int main()
{
    int totalAccounts;
    cin >> totalAccounts;
    vector<UserAccount> accounts(totalAccounts);
    unordered_map<int, int> idToIndex;

    for (int i = 0; i < totalAccounts; ++i)
    {
        cin >> accounts[i].id >> accounts[i].funds;
        idToIndex[accounts[i].id] = i;
    }

    int transactionCount;
    cin >> transactionCount;

    for (int i = 0; i < transactionCount; ++i)
    {
        int fromID, toID, amount;
        cin >> fromID >> toID >> amount;

        int fromIndex = idToIndex[fromID];
        int toIndex = idToIndex[toID];

        if (accounts[fromIndex].funds >= amount)
        {
            accounts[fromIndex].funds -= amount;
            accounts[toIndex].funds += amount;
            cout << "Success" << endl;
        }
        else
        {
            cout << "Failure" << endl;
        }
    }

    cout << endl;
    sort(accounts.begin(), accounts.end(), sortByFunds);
    for (const auto &account : accounts)
    {
        cout << account.id << " " << account.funds << endl;
    }

    return 0;
}
