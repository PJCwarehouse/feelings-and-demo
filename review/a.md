function isEvenSequenceRecursive(arr, index, currentSize, resultArray,n):
    if index >= len(arr):
        return resultArray

    if arr[index] == 1:
        currentSize += 1
        return isEvenSequenceRecursive(arr, index + 1, currentSize, resultArray,n)
    else if currentSize == 1
        currentSize == 0
        return isEvenSequenceRecursive(arr, index + 1, currentSize, resultArray,n)
    else:
        resultArray[n+1] = (currentSize % 2 == 0)//能被2整除，序列大小为偶数，返回1，反之返回0
        currentSize = 0
        return isEvenSequenceRecursive(arr, index + 1, currentSize, resultArray,n+1)

initialize an empty resultArray of the same length as input arr
initialize index = 0 and currentSize = 0 and n = -1
resultArray = isEvenSequenceRecursive(arr, index, currentSize, resultArray)
resultArray数组对应的是每个连续为1的序列大小是否为偶数，是的话为true，不是的话为false
