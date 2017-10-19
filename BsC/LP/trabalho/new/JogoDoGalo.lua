--[classe TicTacToe com um tabuleiro e size]--
function TicTacToe()
	--[variaveis globais]--
	local self = {
		tab = {},
		s = 0,
		lastPlayed = "o" --[X always starts first]--
	}
	--[variaveis locais (privadas)]--
	local inserted = 0

	--[metodos da classe]--
	function self.newTable(n)
		num = 1

		for i=1,n do
			self.tab[i] = {}
			for j=1,n do
				self.tab[i][j] = tostring(num)
				num = num + 1
			end
		end
		self.s = n
	end

	function self.empate()
		plays = self.s * self.s
		finished = self.finished()
		if plays == inserted and not finished then
			return true
		else
			return false
		end
 	end

	function self.getTable()
		return self.tab
	end

	function self.getSize()
		return self.s+1
	end
    
	function self.getLastPlayed()
		return self.lastPlayed
	end

	
	function self.inserted()
		return inserted
	end

	function self.playBot(p)

		if p == self.lastPlayed then
			return "Not your turn"
		else
			while 1 do
				math.randomseed( os.time() )
				x = math.random(self.s)
				math.randomseed( os.time() )
				y = math.random(self.s)

				if self.tab[x][y] == "x" or self.tab[x][y] == "o" then
					io.write("Cant play there (" .. x .. ", " .. y .. ")")
				else
					self.tab[x][y] = p
					inserted = inserted + 1
					return x .. "," .. y
				end
			end
		end
	end

	--[ Funcao principal para fazer uma jogada com o simbolo p ]--
	function self.play(i, j, p)
		if (i < tostring(1) or i > tostring(self.s)) or (j < tostring(1) or j > tostring(self.s)) then
			return "Nao pode jogar nessa posicao (fora do array)"
		elseif p == self.lastPlayed then
			return "Nao pode jogar nessa posicao (jogador ja jogou)"
		elseif self.tab[tonumber(i)][tonumber(j)] == "x" or self.tab[tonumber(i)][tonumber(j)] == "o" then
			return "Nao pode jogar nessa posicao (posicao ja ocupada)"
		elseif self.finished() then
			return "Nao pode jogar o jogo ja acabou"
		end


		self.tab[tonumber(i)][tonumber(j)] = p
		inserted = inserted + 1

		if self.lastPlayed == "x" then
			self.lastPlayed = "o"
		else
			self.lastPlayed = "x"
		end

		return "ok"
	end

	--[ Verificar diagonal esquerda ]--
	function self.leftDiag()
		value = self.tab[1][1]

		s = ""

		for i=1, self.s do
			s = s .. self.tab[i][i]
		end

		if s == "ooo" or s == "xxx" then
			return true
		else
			return false
		end
	end

	--[ Verificar diagonal direita ]--
	function self.rightDiag()
		value = self.tab[1][self.s]
		s = ""

		for i=1, self.s do
			s = s .. self.tab[self.s-i+1][i]
		end

		if s == "ooo" or s == "xxx" then
			return true
		else
			return false
		end
	end

	--[ Verificar linha n ]--
	function self.row(n)
		value = self.tab[n][1]

		for i=1, self.s do
			if self.tab[n][i] ~= value then
				return false
			end
		end

		return true
	end

	--[ Verificar coluna n ]--
	function self.column(n)
		value = self.tab[1][n]

		for i=1, self.s do
			if self.tab[i][n] ~= value then
				return false
			end
		end

		return true
	end

	--[ Verificar diagonais ]--
	function self.diagonals()
		return (self.leftDiag() or self.rightDiag())
	end

	-- [ Verificar linhas ]--
	function self.rows()
		for i=1, self.s do
			if self.row(i) then
				return true
			end
		end

		return false
	end

	--[ Verificar colunas ]--
	function self.columns()
		for i=1, self.s do
			if self.column(i) then
				return true
			end
		end

		return false
	end

	--[ Verificar se o jogo ja acabou ]--
	function self.finished()
		return self.diagonals() or self.rows() or self.columns()
	end

	--[ Print da table do jogo do galo ]--
	function self.printTab()
		out = ""

		for i=1,self.s do
			for j=1,self.s do
				out = out .. "  " .. self.tab[i][j]
			end
			out = out .. "\n"
		end
		out = out .. "\n"

		return out
	end

	return self
end
--[end of class TicTacToe]--