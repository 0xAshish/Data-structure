def kmp(prefix,text):
    s=prefix+'$'+text
    ar = [0 for x in range(len(s))]
    b = 0
    pindex=[]
    for i in range(1, len(s)):
        while (b > 0 and s[i] != s[b]):
            b = ar[b - 1]
        if s[i] == s[b]:
            b += 1
        else:
            b = 0
        ar[i] = b
        if ar[i]==len(prefix):
            pindex.append(i-len(prefix)-2)
    return ar, pindex
ar,indexes= kmp('aa','aasahaaaisaaaaaaahaaaaa')
