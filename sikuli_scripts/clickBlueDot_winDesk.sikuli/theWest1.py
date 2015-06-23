biggest = Region(195,139,309,234)
bigger = Region(266,141,164,140)
big = Region(287,159,125,103)
small = Region(284,176,125,80)
smaller = Region(317,191,64,54)
smallest = Region(318,193,59,45)


blueDot = Pattern("1272820165551.png").similar(0.63)


#if find("1272831025921.png"):
#   doubleClick("1272831025921.png")
#   untilNotExist("1272831025921.png")
   

if smallest.inside().find(blueDot):
   doubleClick(smallest.inside().find(blueDot))
   print("smallest")
elif smaller.inside().find(blueDot):
   doubleClick(smaller.inside().find(blueDot))
   print("smaller")
elif small.inside().find(blueDot):
   doubleClick(small.inside().find(blueDot))
   print("small")
elif big.inside().find(blueDot):
   doubleClick(big.inside().find(blueDot))
   print("big")
elif bigger.inside().find(blueDot):
   doubleClick(bigger.inside().find(blueDot))
   print("bigger")
elif biggest.inside().find(blueDot):
   doubleClick(biggest.inside().find(blueDot))
   print("biggest")
