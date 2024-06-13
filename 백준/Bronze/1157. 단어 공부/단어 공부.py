word = input().upper()
spells = list(set(word))
lst = []
for spell in spells:
    lst.append(word.count(spell))
if lst.count(max(lst)) >= 2:
    print('?')
else:
    print(spells[lst.index(max(lst))])