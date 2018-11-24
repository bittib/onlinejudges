package leetcode.datastructures.disjointSet.medium.LC_721_Accounts_Merge; /**
Given a list accounts, each element accounts[i] is a list of strings, where the first element accounts[i][0] is a name, and the rest of the elements are emails representing emails of the account.

Now, we would like to merge these accounts. Two accounts definitely belong to the same person if there is some email that is common to both accounts. Note that even if two accounts have the same name, they may belong to different people as people could have the same name. A person can have any number of accounts initially, but all of their accounts definitely have the same name.

After merging the accounts, return the accounts in the following format: the first element of each account is the name, and the rest of the elements are emails in sorted order. The accounts themselves can be returned in any order.

Example 1:

Input: 
accounts = [["John", "johnsmith@mail.com", "john00@mail.com"], ["John", "johnnybravo@mail.com"], ["John", "johnsmith@mail.com", "john_newyork@mail.com"], ["Mary", "mary@mail.com"]]
Output: [["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'],  ["John", "johnnybravo@mail.com"], ["Mary", "mary@mail.com"]]
Explanation: 
The first and third John's are the same person as they have the common email "johnsmith@mail.com".
The second John and Mary are different people as none of their email addresses are used by other accounts.
We could return these lists in any order, for example the answer [['Mary', 'mary@mail.com'], ['John', 'johnnybravo@mail.com'], 
['John', 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com']] would still be accepted.
Note:

The length of accounts will be in the range [1, 1000].
The length of accounts[i] will be in the range [1, 10].
The length of accounts[i][j] will be in the range [1, 30].
 */
import java.util.*;
public class DisjointSetSolution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        DS ds = new DS();

        Map<String, Integer> emailToId = new HashMap<>();
        Map<String, String> emailToName = new HashMap<>();

        int id = 0;
        for (List<String> account : accounts) {
            for (int i = 1; i < account.size(); i++) {
                emailToName.put(account.get(i), account.get(0));
                if (!emailToId.containsKey(account.get(i))) {
                    emailToId.put(account.get(i), id++);
                }
                ds.union(emailToId.get(account.get(1)), emailToId.get(account.get(i)));
            }
        }

        Map<Integer, List<String>> emailMap = new HashMap<>();
        for (String email : emailToName.keySet()) {
            int index = ds.find(emailToId.get(email));
            emailMap.computeIfAbsent(index, x -> new ArrayList()).add(email);
        }

        List<List<String>> solution = new ArrayList<>();
        for (List<String> emails : emailMap.values()) {
            List<String> list = new ArrayList<>();
            list.add(emailToName.get(emails.get(0)));
            list.addAll(emails);
            solution.add(list);
        }

        return solution;
    }
}

class DS {
    int[] parent;
    public DS() {
        parent = new int[10001];

        for (int i = 0; i < 10001; i++) {
            parent[i] = i;
        }
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public void union(int x, int y) {

        parent[find(x)] = find(y);
    }
}

