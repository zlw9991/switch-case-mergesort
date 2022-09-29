# switch_case_mergesort
Java based mergesort which uses switch case with if else instead of purely if else, see compare.java.

Fixed time comparison, switch-case is shown to provide a slight decrement in time required for large arrays.

Unique code snippets:
```
// boolean algebra / logic to determine if number is - or +:
(~(0)>>>1) ^((~(0)>>>1) | <number to compare>)
// how it works:
/*
for most code:
(decimal) 0 = 0000....0000 (binary)
~0 = 111....111
(~0)>>>1 (shift bits right by one, do not save end bit:) = 011...111

for negative integers, their first MSB is always 1, while positive numbers are always 0, ie:
MSB
|
0111 (7)
1000 (-8)

thus when 011...111 ORs with a positive number: it will always be 011...111, unchanged.
but if 011...111 ORs with a negative number, it will be: 111...111, changed.

thus, when these two values are XOR'd with their old value:
positive numbers will always produce a 0.
negative numbers will always produce a non-zero.

*/
```


Comparisons:

IE: (standard mergesort)
```
while (l1c < l1.length && l2c < l2.length) {
			//swc = l1[l1c] - l2[l2c];
			
				if(l1[l1c] - l2[l2c] < 0) {
					mergec++;
					rtl[rtc] = l1[l1c];
					l1c++;
					rtc++;
				} else if (l1[l1c] - l2[l2c] > 0){
					mergec++;
					rtl[rtc] = l2[l2c];
					l2c++;
					rtc++;
				} else {
					mergec++;
					rtl[rtc] = l1[l1c];
					l1c++;
					rtc++;
					rtl[rtc] = l2[l2c];
					l2c++;
					rtc++;
				}
			
		}
```

VS

(partial switch-case mergesort)
```
while (l1c < l1.length && l2c < l2.length) {
			//swc = l1[l1c] - l2[l2c];
			switch(l1[l1c] - l2[l2c]) {
			case 0:
				mergec++;
				rtl[rtc] = l1[l1c];
				l1c++;
				rtc++;
				rtl[rtc] = l2[l2c];
				l2c++;
				rtc++;
				break;
			default:
				if(l1[l1c] - l2[l2c] < 0) {
					mergec++;
					rtl[rtc] = l1[l1c];
					l1c++;
					rtc++;
					//break;
				} else {
					mergec++;
					rtl[rtc] = l2[l2c];
					l2c++;
					rtc++;
				}
			}
		}

```
VS

(full switch-case mergesort)
```
while (l1c < l1.length && l2c < l2.length) {
						//swc = l1[l1c] - l2[l2c];
			
			
			switch(l1[l1c] - l2[l2c]) {
			case 0:
				mergec++;
				rtl[rtc] = l1[l1c];
				l1c++;
				rtc++;
				rtl[rtc] = l2[l2c];
				l2c++;
				rtc++;
				break;
			default:
				//swc = (int) (((swc)|~(swc))>>>1) ^((((swc)|~(swc))>>>1) | swc);
				//swc = (int) (~(0)>>>1) ^((~(0)>>>1) | l1[l1c] - l2[l2c]); ~((~(0)>>>1)|val)
				//(int) (~(0)>>>1) ^((~(0)>>>1) | l1[l1c] - l2[l2c])
				switch((int)
						~((~(0)>>>1)|l1[l1c] - l2[l2c])
						) {
				case 0:
					mergec++;
					rtl[rtc] = l1[l1c];
					l1c++;
					rtc++;
					break;
				default:
					mergec++;
					rtl[rtc] = l2[l2c];
					l2c++;
					rtc++;
				}
				
			}
		}
```
