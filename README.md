# switch_case_mergesort
Java based mergesort which uses switch case with if else instead of purely if else, see compare.java.

Fixed time comparison, switch-case is shown to provide a slight decrement in time required for large arrays.

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
				//swc = (int) (~(0)>>>1) ^((~(0)>>>1) | l1[l1c] - l2[l2c]);
				switch((int) (~(0)>>>1) ^((~(0)>>>1) | l1[l1c] - l2[l2c])) {
				case 0:
					mergec++;
					rtl[rtc] = l2[l2c];
					l2c++;
					rtc++;
					
					break;
				default:
					mergec++;
					rtl[rtc] = l1[l1c];
					l1c++;
					rtc++;
				}
				
			}
		}
```
