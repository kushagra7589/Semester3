#include <bits/stdc++.h>

using namespace std;
const int MAX_SIZE = 110;
typedef long long ll;

bool flag[MAX_SIZE];

int main()
{
	ios_base::sync_with_stdio(false);
	int n, m;
	cin >> n >> m;
	int x, y;
	for(int i=1; i<=m; i++)
		flag[i] = false;
	for(int i=0; i<n; i++)
	{
		cin >> x;
		for(int j=0; j<x; j++)
		{
			cin >> y;
			flag[y] = true;
		}
	}
	bool ans = true;
	for(int i=1; i<=m; i++)
	{
		ans = ans && flag[i];
	}
	if(ans)
		cout << "YES";
	else
		cout << "NO"
	cout << endl;
	return 0;
}