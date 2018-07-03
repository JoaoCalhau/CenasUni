var packingList = ["Socks", "Shoes"]

print(packingList[0])
packingList.append("Trousers")
packingList[2] = "Jeans"
packingList.append(contentsOf: ["Shorts", "Sandals", "Sunblock"])

print(packingList)