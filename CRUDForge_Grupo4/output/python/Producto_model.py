from sqlalchemy import Column, String, Integer, Numeric, Boolean, DateTime
from sqlalchemy.orm import declarative_base

Base = declarative_base()

class Producto(Base):
    __tablename__ = "producto"
    id = Column(String, primary_key=True)
    nombre = Column(String, nullable=False)
    precio = Column(Numeric, )
    stock = Column(Integer, default='0')
    categoria = Column(Integer, )
