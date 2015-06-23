biggest = Region(239,155,235,244)
bigger = Region(294,165,133,128)
big = Region(304,179,103,92)
small = Region(317,189,77,71)
smaller = Region(328,199,56,51)
smallest = Region(341,208,29,33)


blueDot = Pattern("1272820165551.png").similar(0.84)


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
