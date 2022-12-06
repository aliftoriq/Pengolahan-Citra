# Nama  : Alif Toriq Alkausar
# NIM   : 09021182025016

import cv2

pixel  = cv2.imread("D:/Tes_Citra.jpg")
# pixel  = cv2.imread("D:/Tes_Citra_1.jpg")
# pixel  = cv2.imread("D:/Walpaper/632051.png")

cv2.imshow("pixel", pixel)

# Pixel gambar
print("Ukuran Gambar", pixel.shape[0], " x " , pixel.shape[1] , " pixel")

# Mengakses koordinat dan RGB pada point yang ditunjuk mouse
def RGBPoint(event, x, y, flags, params):
    if (event == cv2.EVENT_FLAG_LBUTTON): 
        print("Point :(", x, "," ,y, ")")
        print("RGB : (%d, %d, %d)" % (pixel[y][x][2], pixel[y][x][1] , pixel[y][x][0])) 
        cv2.imshow("pixel", pixel)
        print("\n")

cv2.setMouseCallback('pixel', RGBPoint) 
cv2.waitKey(0)
cv2.destroyAllWindows()