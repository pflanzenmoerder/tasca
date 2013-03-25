insert into TS_USER(ID, NAME, PASSWORD, SALT) values('user1', 'user1', 'testPass', '12');
insert into TS_USER(ID, NAME, PASSWORD, SALT) values('userWithoutTasks', 'userWithoutTasks', 'testPass', '12');
insert into TS_USER(ID, NAME, PASSWORD, SALT) values('writeUser', 'writeUser', 'testPass', '12');
insert into TS_TASK(ID,OWNER_ID, TASK_LIST_ID, NAME) values('task1', 'user1', NULL, 'task1');
insert into TS_TASK(ID,OWNER_ID, TASK_LIST_ID, NAME) values('task2', 'user1', NULL, 'task2');
insert into TS_TASK_LIST(ID, USER_ID, TITLE) values('taskList1', 'user1', 'testList');
insert into TS_TASK_LIST(ID, USER_ID, TITLE) values('taskList2', 'writeUser', 'testList2');
insert into TS_TASK(ID,OWNER_ID, TASK_LIST_ID, NAME) values('task3', 'user1', 'taskList1', 'taskInTaskList');
