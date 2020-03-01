import random

piasek = 'o'
puste = ' '
sciana = 'X'
wchlaniajaca = 'W'


class Piasek:
    def __init__(self):
        self.siatka = []
        self.rozmiar_x = 0
        self.rozmiar_y = 0
        self.parzysty_rozmiar_x = 0
        self.parzysty_rozmiar_y = 0
        self.krok = 0

    def wczytaj_z_pliku(self, sciezka):
        with open(sciezka) as plik:
            linnia_pliku = plik.readlines()

        self.rozmiar_x = len(linnia_pliku[0]) - 1
        self.rozmiar_y = len(linnia_pliku) - 1

        if self.rozmiar_x % 2 == 0:
            lewy_x = 1
            prawy_x = 1
        else:
            lewy_x = 1
            prawy_x = 0

        if self.rozmiar_y % 2 == 0:
            dolny_y = 0
        else:
            dolny_y = 1

        self.parzysty_rozmiar_x = lewy_x + self.rozmiar_x + prawy_x
        self.parzysty_rozmiar_y = self.rozmiar_y + dolny_y

        self.siatka = [[puste] * self.parzysty_rozmiar_x for i in range(self.parzysty_rozmiar_y)]

        for i in range(self.parzysty_rozmiar_y):
            self.siatka[i][0] = sciana

        if prawy_x:
            for i in range(self.parzysty_rozmiar_y):
                self.siatka[i][self.parzysty_rozmiar_x - 1] = sciana

        if dolny_y:
            self.siatka[self.parzysty_rozmiar_y - 1] = [sciana] * self.parzysty_rozmiar_x

        for i in range(self.rozmiar_y):
            for j in range(self.rozmiar_x):
                if linnia_pliku[i][j] == 'X':
                    self.siatka[i][j + 1] = sciana
                elif linnia_pliku[i][j] == 'W':
                    self.siatka[i][j + 1] = wchlaniajaca
                else:
                    self.siatka[i][j + 1] = puste

    def generuj_piasek(self, ile_piachu):
        for i in range(ile_piachu):
            # tutaj mozna edytowac czy ma spadac na calej szerokosci
            los = random.randint(0, self.rozmiar_x)
            self.siatka[0][los] = piasek

    def zrob_krok(self):
        if self.krok % 2 == 0:
            for i in range(0, self.parzysty_rozmiar_y - 1, 2):
                for j in range(1, self.parzysty_rozmiar_x - 2, 2):

                    if self.siatka[i][j] == piasek and self.siatka[i + 1][j] == puste:
                        self.siatka[i][j] = puste
                        self.siatka[i + 1][j] = piasek

                    if self.siatka[i][j + 1] == piasek and self.siatka[i + 1][j + 1] == puste:
                        self.siatka[i][j + 1] = puste
                        self.siatka[i + 1][j + 1] = piasek

                    if self.siatka[i][j] == piasek and self.siatka[i + 1][j] == wchlaniajaca:
                        self.siatka[i][j] = puste

                    if self.siatka[i][j + 1] == piasek and self.siatka[i + 1][j + 1] == wchlaniajaca:
                        self.siatka[i][j + 1] = puste

                    if self.siatka[i][j] == piasek and self.siatka[i + 1][j] == piasek and self.siatka[i][
                        j + 1] == puste and self.siatka[i + 1][j + 1] == puste:
                        self.siatka[i][j] = puste
                        self.siatka[i + 1][j + 1] = piasek

                    if self.siatka[i][j + 1] == piasek and self.siatka[i + 1][j + 1] == piasek and self.siatka[i][
                        j] == puste and self.siatka[i + 1][j] == puste:
                        self.siatka[i][j + 1] = puste
                        self.siatka[i + 1][j] = piasek
        else:
            for i in range(1, self.parzysty_rozmiar_y - 2, 2):
                for j in range(0, self.parzysty_rozmiar_x - 1, 2):
                    self.siatka[i][j] = self.siatka[i][j]
                    self.siatka[i][j + 1] = self.siatka[i][j + 1]
                    self.siatka[i + 1][j] = self.siatka[i + 1][j]
                    self.siatka[i + 1][j + 1] = self.siatka[i + 1][j + 1]

                    if self.siatka[i][j] == piasek and self.siatka[i + 1][j] == puste:
                        self.siatka[i][j] = puste
                        self.siatka[i + 1][j] = piasek

                    if self.siatka[i][j + 1] == piasek and self.siatka[i + 1][j + 1] == puste:
                        self.siatka[i][j + 1] = puste
                        self.siatka[i + 1][j + 1] = piasek

                    if self.siatka[i][j] == piasek and self.siatka[i + 1][j] == wchlaniajaca:
                        self.siatka[i][j] = puste

                    if self.siatka[i][j + 1] == piasek and self.siatka[i + 1][j + 1] == wchlaniajaca:
                        self.siatka[i][j + 1] = puste

                    if self.siatka[i][j] == piasek and self.siatka[i + 1][j] == piasek and self.siatka[i][
                        j + 1] == puste and self.siatka[i + 1][j + 1] == puste:
                        self.siatka[i][j] = puste
                        self.siatka[i + 1][j + 1] = piasek

                    if self.siatka[i][j + 1] == piasek and self.siatka[i + 1][j + 1] == piasek and self.siatka[i][
                        j] == puste and self.siatka[i + 1][j] == puste:
                        self.siatka[i][j + 1] = puste
                        self.siatka[i + 1][j] = piasek
        self.krok += 1
