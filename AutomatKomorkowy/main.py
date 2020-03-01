from xd.piasek import *
import sys
import pygame



naczynia = ["miska.txt","okrag.txt","skosy.txt","klepsydra.txt"]
print("Dostępne naczynia to : ")
print("1. Miska, 2. Okrag, 3. Skosy, 4. Klepsydra")
wybor = int(input("Prowadz numer wybranego naczynia : "))
sciezka = naczynia[wybor-1]

ustawienia = input("Czy chcesz użyć ustawień standardowych? TAK/NIE")
if ustawienia == "TAK":
    mnoznik_wysokosci_okna = 7
    szybkosc = 3
    rzadkosc_piasku = 5
    jak_duzo_piasku = 4
else:
    mnoznik_wysokosci_okna = int(input("Podaj wielkosc (domyslnie 4) : "))
    szybkosc = int(input("Podaj szybkość (domyslnie 5) : "))
    rzadkosc_piasku = int(input("Podaj częstotliwość (domyslnie 2) : "))
    jak_duzo_piasku = int(input("Podaj iloscp piasku (domyslnie 4) : "))

siatka = Piasek()
siatka.wczytaj_z_pliku(sciezka)

okno_gry_szerokosc = siatka.rozmiar_x * mnoznik_wysokosci_okna
okno_gry_wysokosc = siatka.rozmiar_y * mnoznik_wysokosci_okna
okno_gry = pygame.display.set_mode((okno_gry_szerokosc, okno_gry_wysokosc), 0, 32)

def rysuj_piasek(siatka):
    for i in range(siatka.rozmiar_y):
        for j in range(siatka.rozmiar_x):
            if siatka.siatka[i][j+1] == piasek:
                pygame.draw.circle(okno_gry, (253, 255, 0), (j * mnoznik_wysokosci_okna + 1 * mnoznik_wysokosci_okna // 2, i * mnoznik_wysokosci_okna + 1 * mnoznik_wysokosci_okna // 2), 1 * mnoznik_wysokosci_okna // 2)
            if siatka.siatka[i][j+1] == sciana:
                pygame.draw.rect(okno_gry, (226, 226, 226), pygame.Rect((j * mnoznik_wysokosci_okna, i * mnoznik_wysokosci_okna), (1 * mnoznik_wysokosci_okna, 1 * mnoznik_wysokosci_okna)))
            if siatka.siatka[i][j+1] == wchlaniajaca:
                pygame.draw.rect(okno_gry, (255, 197, 197), pygame.Rect((j * mnoznik_wysokosci_okna, i * mnoznik_wysokosci_okna), (1 * mnoznik_wysokosci_okna, 1 * mnoznik_wysokosci_okna)))

generuj = True
pygame.display.set_caption('Opadanie Piasku - ZadanieIII')
while True:
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            pygame.quit()
            sys.exit()


    if siatka.krok % rzadkosc_piasku == 0 and generuj:
        siatka.generuj_piasek(jak_duzo_piasku)

    siatka.zrob_krok()
    okno_gry.fill((0, 0, 0))
    rysuj_piasek(siatka)
    pygame.display.update()
    pygame.time.delay(szybkosc)
