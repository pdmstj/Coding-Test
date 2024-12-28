def solution(id_list, report, k):
    report = set(report)
    
    reported_count = {user: 0 for user in id_list}
    user_reports = {user: [] for user in id_list}
    
    for rep in report:
        reporter, reported = rep.split()
        reported_count[reported] += 1
        user_reports[reporter].append(reported)
    
    banned_users = {user for user, count in reported_count.items() if count >= k}
    
    result = []
    for user in id_list:
        mail_count = sum(1 for reported in user_reports[user] if reported in banned_users)
        result.append(mail_count)
    
    return result
