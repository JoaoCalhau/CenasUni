function factorial(n)
  local x = 1
  for i = 2, n do
    x = x * i
  end
  return x
end

--[[
n = io.read()
while n ~= "y" do
	print("Continue? (y/n)")
	n = io.read()
end
]]--

function toString(a)
	i = 1
	s = "["
	while i > #a do
		s = s + "Point(" + a[i].x + ", " + a[i].y + ")"
		i = i + 1
	end
	s = s + "]"
	return s
end

function Point(x, y)
	return { x = x, y = y}
end

array = { Point(10, 20), Point(30, 40), Point(50, 60) }

print(toString(array))
