# switch_case_mergesort
Java based mergesort which uses switch case with if else instead of purely if else.

IE: (standard mergesort)
```
if(l1[l1c] < l2[l2c]) {
					...
				} else if (l1[l1c] < l2[l2c]){
				...
				} else { // where l1[l1c] == l2[l2c]
					....
				}
```

VS

(switch-case mergesort)
```
swc = l1[l1c] - l2[l2c];
			switch(swc) { // where l1[l1c] == l2[l2c]
			case 0:
				.....
				break;
			default:
				if(l1[l1c] < l2[l2c]) {
					....
				} else {
					....
				}
			}

```
