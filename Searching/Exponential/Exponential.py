def binary_search(arr, target, low, high):
    while low <= high:
        mid = (low + high) // 2
        if arr[mid] == target:
            return mid
        elif arr[mid] < target:
            low = mid + 1
        else:
            high = mid - 1
    return -1


def exponential_search(arr, target):
    if not arr:
        return -1

    if arr[0] == target:
        return 0

    i = 1
    while i < len(arr) and arr[i] <= target:
        i *= 2

    # Do binary search between i/2 and min(i, len(arr)-1)
    return binary_search(arr, target, i // 2, min(i, len(arr) - 1))
