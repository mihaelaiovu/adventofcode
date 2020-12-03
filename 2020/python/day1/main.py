with open("input.txt", 'r') as f:
    content = f.readlines()
    x = [int(x.strip()) for x in content]

for i in range(len(x)):
    for j in range(i, len(x)):
        if x[i] + x[j] == 2020:
            print(x[i] * x[j])

for i in range(len(x)):
    for j in range(i, len(x)):
        for k in range(j, len(x)):
            if x[i] + x[j] + x[k] == 2020:
                print(x[i] * x[j] * x[k])