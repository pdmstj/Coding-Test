while True:
    weight = float(input())
    if weight < 0:
        break
    moon_weight = weight * 0.167
    print(f"Objects weighing {weight:.2f} on Earth will weigh {moon_weight:.2f} on the moon.")