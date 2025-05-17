# -*- coding: utf-8 -*-
# @Author  : YongbinMiao
# @Time    : 2024-05-22 11:50:27
from typing import List
from fastapi import FastAPI, Depends, HTTPException
from sqlalchemy.orm import Session
from pydantic import BaseModel
from sqlalchemy import Column, Integer, String, create_engine
from sqlalchemy.ext.declarative import declarative_base
from sqlalchemy.orm import sessionmaker
from fastapi.middleware.cors import CORSMiddleware

# 配置你的数据库连接URL（确保数据库已经创建好）
DATABASE_URL = "mysql+pymysql://root:123456@localhost/flink?charset=utf8mb4"

# 连接到数据库
engine = create_engine(DATABASE_URL)
SessionLocal = sessionmaker(autocommit=False, autoflush=False, bind=engine)
Base = declarative_base()


# 数据库 ORM 模型
class Click(Base):
    __tablename__ = "clicks_pv"
    url = Column(String(100), primary_key=True)
    count = Column(Integer)


# Pydantic 响应模型
class ClickModel(BaseModel):
    url: str
    count: int

    class Config:
        orm_mode = True


# 实际数据库获取功能
def get_db():
    db = SessionLocal()
    try:
        yield db
    finally:
        db.close()


# FastAPI 应用实例
app = FastAPI()

# 允许的起源列表，可以使用通配符 "*" 允许所有起源
origins = [
    "http://localhost",
    "http://localhost:63342",
    # "http://localhost:3000",  # 如果你的前端在别的端口
    # 更多你的前端URL
]

app.add_middleware(
    CORSMiddleware,
    allow_origins=origins,
    allow_credentials=True,
    allow_methods=["*"],  # 或者只允许使用的HTTP方法 ["GET", "POST"]
    allow_headers=["*"],  # 或者只允许特定的头
)


# FastAPI 路由（注意：现在使用 Pydantic 模型）
@app.get("/clicks/", response_model=List[ClickModel])
def read_clicks(db: Session = Depends(get_db)):
    clicks = db.query(Click).all()
    return clicks


@app.get("/")
def read_root():
    return {"Hello": "World"}


# 运行FastAPI应用
if __name__ == "__main__":
    import uvicorn

    uvicorn.run(app, host="0.0.0.0", port=8000)
