import cv2
cap = cv2.VideoCapture('../OpenCV/city.mp4')
fourcc = cv2.VideoWriter_fourcc(*'DIVX')
width = round(cap.get(cv2.CAP_PROP_FRAME_WIDTH))
height = round(cap.get(cv2.CAP_PROP_FRAME_HEIGHT))
# 영상 속도 4배
fps = cap.get(cv2.CAP_PROP_FPS)*4
# 출력 파일명
out = cv2.VideoWriter('../OpenCV/city_output.avi', fourcc, fps, (width,height))

while cap.isOpened():
    ret, frame = cap.read()
    if not ret:
        break
    # 시계 반대방향으로 90도 회전
    rotate_270 = cv2.rotate(frame, cv2.ROTATE_90_COUNTERCLOCKWISE)

    out.write(rotate_270)
    cv2.imshow('video', rotate_270)
    if cv2.waitKey(1)==ord('q'):
        break

out.release()
cap.release()
cv2.destroyAllWindows()

