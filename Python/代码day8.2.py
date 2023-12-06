from random import randrange

玩家, 机器人 = 5, 5
游戏局数 = 0

def 掷骰子(骰子点数, 押大押小):
    if 骰子点数 == 7:
        print(f'骰子的点数是 {骰子点数};\n平局!\n')
        return 0
    elif 骰子点数 < 7:
        if 押大押小 == '小':
            print(f'骰子的点数是 {骰子点数};\n您赢了!\n')
            return 1
        else:
            print(f'骰子的点数是 {骰子点数};\n您输了!\n')
            return -1
    elif 骰子点数 > 7:
        if 押大押小 == '小':
            print(f'骰子的点数是 {骰子点数};\n您输了!\n')
            return -1
        else:
            print(f'骰子的点数是 {骰子点数};\n您赢了!\n')
            return 1

while True:
    print(f'您的筹码:{玩家}\n')
    print(f'机器人的筹码:{机器人}')
    print("您可以在任何时候敲 '退' 退出。")
    骰子点数 = randrange(2, 13)
    押大押小 = input("您押大还是押小?（输入'大'或者'小'即可）")
    if 押大押小 == '退':
        break
    elif 押大押小 in '大' or '小':
        result = 掷骰子(骰子点数, 押大押小)
        玩家 += result      # 玩家筹码 = 玩家筹码 +那个return的值。
        机器人 -= result
        游戏局数 += 1
    if 玩家 == 0:
        print("您没有筹码了，游戏结束了!")
        break
    elif 机器人 == 0:
        print("机器人的筹码都被您给赢走了，游戏结束!")
        break

print(f"您玩了 {游戏局数}局 。\n")
print(f"您有 {玩家}筹码 。\n期待您的再次光临!")
